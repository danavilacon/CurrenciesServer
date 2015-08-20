#!/bin/bash

su - vagrant -c "curl -s get.gvmtool.net | bash"
su - vagrant -c 'source "/home/vagrant/.gvm/bin/gvm-init.sh"'
su - vagrant -c "gvm i lazybones"
su - vagrant -c "gvm d lazybones"
su - vagrant -c "gvm i gradle 2.2.1"
su - vagrant -c "gvm d gradle 2.2.1"