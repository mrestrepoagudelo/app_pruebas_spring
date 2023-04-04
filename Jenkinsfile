pipeline{
    agent any
    tools { 
      maven 'MAVEN_HOME' 
    }
    stages{
        stage('Git clone'){
            steps{
                git 'https://github.com/mrestrepoagudelo/app_pruebas_spring.git'
            }
        }
        stage('Mavent test'){
            steps{
               sh 'mvn test'
            }
        }
        
        stage('Maven Build'){
            steps{
               sh 'mvn package'
            }
        }
        
        stage('Maven Deploy'){
            steps{
               echo 'Maven Deploy war file'
            }
        }
       
    }
}
