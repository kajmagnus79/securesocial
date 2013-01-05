/*
 * Copyright 2012 Typesafe (http://www.typesafe.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this project except in compliance with the License. You may
 * obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.typesafe.plugin;

public interface MailerApiJavaInterop {

  /**
   * Sets a subject for this email. It enables formatting of the providing string using Java's
   * string formatter.
   *
   * @param subject
   * @param args
   */
  public MailerAPI setSubject(String subject, java.lang.Object... args);

  /**
   * Adds an email recipient in CC.
   *
   * @param ccRecipients
   */
  public MailerAPI addCc(String... ccRecipients);

  /**
   * Adds an email recipient in BCC.
   *
   * @param bccRecipients
   */
  public MailerAPI addBcc(String... bccRecipients);

  /**
   * Adds an email recipient ("to" addressee).
   *
   * @param recipients
   */
  public  MailerAPI addRecipient(String... recipients); 
  
}