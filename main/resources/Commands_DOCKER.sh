cd Arnab/
git clone https://github.com/bretfisher/udemy-docker-mastery
docker version
docker info
docker
clear
docker container run --publish 8888:80 nginx
docker container run --publish 80:80 nginx
clear

docker container run -d --name nginx nginx
01897f50c4351f7465c59b87ad22513d7924201a5ce2716dbcb8c305fdaeb711
docker container run -d --name mysql -e MYSQL_RANDOM_ROOT_PASSWORD=true mysql
b2cb16bfbd3b6822c21e3248168b0b4e9b27256552b0961155f2fcc4799ba71f
docker container ls
CONTAINER ID        IMAGE                                                                                                                               COMMAND                  CREATED              STATUS              PORTS                 NAMES
b2cb16bfbd3b        mysql                                                                                                                               "docker-entrypoint..."   19 seconds ago       Up 18 seconds       3306/tcp, 33060/tcp   mysql
01897f50c435        nginx                                                                                                                               "nginx -g 'daemon ..."   About a minute ago   Up About a minute   80/tcp                nginx
94c647859fd8        registry.access.redhat.com/openshift3/ose-docker-registry@sha256:2e785677a85d5d6c418592654f58bab638c322300a83ea7b7fce5898d80c8825   "/bin/sh -c '/usr/..."   3 days ago           Up 3 days                                 k8s_registry_docker-registry-1-wfndq_default_1007fd9f-bb4a-11e8-bebf-005056153171_0
a06d67c80742        registry.access.redhat.com/openshift3/ose-haproxy-router@sha256:849cc2f5f9886318ddcd5b055e8e99e7ce2fe2e48fa633f268d9a781502111d4    "/usr/bin/openshif..."   3 days ago           Up 3 days                                 k8s_router_router-1-n66r2_default_101b7f63-bb4a-11e8-bebf-005056153171_0
4c9cbfaac5c3        registry.access.redhat.com/openshift3/ose-pod:v3.7                                                                                  "/usr/bin/pod"           3 days ago           Up 3 days                                 k8s_POD_docker-registry-1-wfndq_default_1007fd9f-bb4a-11e8-bebf-005056153171_0
efd72f585bb1        registry.access.redhat.com/openshift3/ose-pod:v3.7                                                                                  "/usr/bin/pod"           3 days ago           Up 3 days                                 k8s_POD_router-1-n66r2_default_101b7f63-bb4a-11e8-bebf-005056153171_0
5cdd658f5fb0        registry.access.redhat.com/openshift3/ose:v3.7                                                                                      "/usr/bin/openshif..."   3 days ago           Up 3 days                                 origin
[admin@ilba16085.eaas.amdocs.com|10.238.129.142(eaasrt): ~]$ docker container top mysql
UID                 PID                 PPID                C                   STIME               TTY                 TIME                CMD
polkitd             102204              102187              1                   15:30               ?                   00:00:00            mysqld

docker container run -d --name nginx nginx
  247  docker container run -d --name mysql -e MYSQL_RANDOM_ROOT_PASSWORD=true mysql
  248  docker container ls
  249  docker container top mysql
  250  docker container top nginx
  251  docker container inspect mysql
  252  docker container stats --help
  253  docker container stats
  254  docker container ls
  255  clear
  256  docker container run -it --name proxy nginx bash
  257  docker contaier ls a
  258  docker contaier ls -a
  259  docker container ls -a
  260  clear
  261  docker container run -it --name ubuntu ubuntu
  262  docker container ls
  263  docker container ls -
  264  docker container ls -a
  265  clear
  266  docker container start --help
  267  docker container start -ai ubuntu
  268  docker container exec --help
  269  docker container exec -it mysql bash
  270  docker container ls
  271  docker container stop b2cb16bfbd3b 01897f50c435
  272  docker container ls
  273  clear
  274  docker pull alpine
  275  docker image ls
  276  docker container run -it alpine bash
  277  docker container run -it alpine sh
  278  docker container ls -a
  279  docker stop cfaa893d0a2e
  280  docker container ls -a
 