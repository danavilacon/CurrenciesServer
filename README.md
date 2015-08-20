# CurrenciesServer
Crossover Test

## How to use Vagrant

Vagrant is a tool for building and distributing development environments.

Documentation is located in: [https://docs.vagrantup.com/v2/](https://docs.vagrantup.com/v2/ "Vagrant Documentation")

You need to install Chef-dk (https://downloads.chef.io/chef-dk) and vagrant-berkshelf:

```
vagrant plugin install vagrant-berkshelf
```

## Run Vagrant 

```
cd /path/to/CurrenciesServer/
vagrant up
vagrant ssh
```

## Run Application

```
vagrant ssh
cd /CurrenciesServer/
grails run-app
```

## Visit Application

Visit URL
```
http://192.168.33.20:8080/currencies
```

# PROBLEMS?
