# -*- mode: ruby -*-
# vi: set ft=ruby :

# Vagrantfile API/syntax version. Don't touch unless you know what you're doing!
VAGRANTFILE_API_VERSION = "2"

Vagrant.configure(VAGRANTFILE_API_VERSION) do |config|
  
  config.vm.box = "ubuntu/trusty64" #https://vagrantcloud.com/ubuntu/boxes/trusty64
  config.vm.network "private_network", ip: "192.168.33.20", :mac => "082027880ca6"
  config.vm.synced_folder "./", "/CurrenciesServer"

  config.vm.provider :virtualbox do |vb|
    vb.name = 'server'
    vb.customize ["modifyvm", :id, "--memory", "2048"]
    vb.cpus = 2
  end

  config.berkshelf.enabled = true
  config.vm.provision :chef_solo do |chef|
     
     chef.json = {
        :tz => 'America/Santiago',
        :java => 
        {
          :install_flavor => "oracle",
          :jdk_version => "8",
          :oracle => {
            :accept_oracle_download_terms => true
          }
        },

     }

     chef.add_recipe "apt"
     chef.add_recipe "curl::libcurl"
     chef.add_recipe "java"
     chef.add_recipe "zip"
     chef.add_recipe "redis2"
   end
   config.vm.provision :shell, :path => "bootstrap.sh"
end

