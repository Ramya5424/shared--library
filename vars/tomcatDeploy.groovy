def call (creds,user,ip){
    sshagent(["${creds}"] {
        //copy war file to Tomcat
        sh "scp -0 StrictHostKeyChecking=no target/*.war ${user)@${ip}:/opt/tomcat10/webapps/"
      // Stop and start Tomcat
        sh "ssh ${user)@$(ip} /opt/tomcat10/bin/shutdown.sh" 
        sh "ssh $fuser)@$(ip} /opt/tomcat10/bin/startup.sh"
    }
}
