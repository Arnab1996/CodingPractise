ansible-playbook playbooks/IFRS/install_playbooks/startInstallation.yml -i IFRS_Installation.ini --extra-vars '@/users/pciwrk1/MS_version/OMS_Adapter/omsevent-transform-ms-installer/env_properties.json' --extra-vars 'jvm_args=-Dmanagement.server.port=12001' -vvv

ansible-playbook playbooks/IFRS/install_playbooks/startInstallation.yml -i IFRS_Installation.ini --extra-vars '@/users/pciwrk1/MS_version/MS_Mng/message-management-ms-installer/env_properties.json' --extra-vars 'jacoco_args=-Dmanagement.server.port=12002' -vvv

ansible-playbook playbooks/IFRS/install_playbooks/startInstallation.yml -i IFRS_Installation.ini --extra-vars '@/users/pciwrk1/MS_version/MS_Qual/rr-qualification-ms-installer/env_properties.json' --extra-vars 'jvm_args=-Dmanagement.server.port=12003' -vvv

ansible-playbook playbooks/IFRS/install_playbooks/startInstallation.yml -i IFRS_Installation.ini --extra-vars '@/users/pciwrk1/MS_version/MS_Contract/rr-contract-ms-installer/env_properties.json' --extra-vars 'jacoco_agent_arg=-Dmanagement.server.port=12004' -vvv

ansible-playbook playbooks/IFRS/install_playbooks/startInstallation.yml -i IFRS_Installation.ini --extra-vars '@/users/pciwrk1/MS_version/MS_POB/rr-pob-ms-installer/env_properties.json' --extra-vars 'jvm_args=-Dmanagement.server.port=12005' -vvv

ansible-playbook playbooks/IFRS/install_playbooks/startInstallation.yml -i IFRS_Installation.ini --extra-vars '@/users/pciwrk1/MS_version/Bill/rr-billingprofile-ms-installer/env_properties.json' --extra-vars 'jacoco_agent_arg=-Dmanagement.server.port=12006' -vvv

ansible-playbook playbooks/IFRS/install_playbooks/startInstallation.yml -i IFRS_Installation.ini --extra-vars '@/users/pciwrk1/MS_version/MS_LifeCycle/rr-lifecycle-event-ms-installer/env_properties.json' --extra-vars 'jacoco_agent_arg=-Dmanagement.server.port=12007' -vvv



@author	This tag lets you put the name of the code author into the documentation.
@parameter	This tag is used to define parameters that are passed into a method.
@return	This tag defines values that are returned from methods.
@see	This tag creates "See Also:" output. You'll normally use this tag to refer to related classes.
@version	This tag lets you define the version of the Java code you're developing. For instance, the code displayed in Listing 1 is considered to version 1.0.
