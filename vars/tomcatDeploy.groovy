def call(tomcatIp, warfileName, tomcatUser, remoteUser, credId) {
    sshagent([credId]) {
        sh "scp target/${warfileName} ${tomcatUser}@${tomcatIp}:/opt/tomcat10/webapps"
        sh "ssh ${tomcatUser}@${tomcatIp} /opt/tomcat10/bin/shutdown.sh"
        sh "ssh ${tomcatUser}@${tomcatIp} /opt/tomcat10/bin/startup.sh"
    }
}

