#!/bin/bash
set -x
gitcmd="ssh-add ~/.ssh/github-kajmagnus79-id_rsa; git $@"
ssh-agent bash -c "$gitcmd"

