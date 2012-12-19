/**
 * Copyright 2012 Jorge Aliss (jaliss at gmail dot com) - twitter: @jaliss
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package securesocial.core.providers.utils

import java.security.MessageDigest
import play.api.libs.ws.WS
import securesocial.core.providers.UsernamePasswordProvider
import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

object GravatarHelper {
  val GravatarUrl = "http://www.gravatar.com/avatar/%s?d=404"
  val Md5 = "MD5"

  def avatarFor(email: String): Option[String] = {
    if ( UsernamePasswordProvider.enableGravatar ) {
      hash(email).map( hash => {
        val url = GravatarUrl.format(hash)
        var okayUrl: Option[String] = None
        val futureResponse = WS.url(url).get()
        try {
          val response = Await.result(futureResponse, 10 seconds)
          if (response.status == 200) {
            okayUrl = Some(url)
          }
        }
        catch {
          case scala.util.control.NonFatal(exception) => okayUrl = None
        }
        okayUrl
      }).getOrElse(None)
    } else {
      None
    }
  }

  private def hash(email: String): Option[String] = {
    val s = email.trim.toLowerCase
    if ( s.length > 0 ) {
      val out = MessageDigest.getInstance(Md5).digest(s.getBytes)
      Some(BigInt(1, out).toString(16))
    } else {
      None
    }
  }
}
