#!/bin/bash

su - vagrant -c "curl -s get.gvmtool.net | bash"
su - vagrant -c 'source "/home/vagrant/.gvm/bin/gvm-init.sh"'
su - vagrant -c "gvm i lazybones"
su - vagrant -c "gvm d lazybones"
su - vagrant -c "gvm i gradle"
su - vagrant -c "gvm d gradle"