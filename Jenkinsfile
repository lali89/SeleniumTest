pipeline { 
    agent any  
    stages { 
        stage('Build') { 
            steps { 
               echo 'This is a minimal pipeline.' 
                   sh 'mvn clean compile'
            }
        }
         stage('Test') { 
            steps { 
               echo 'This is a minimal pipeline.' 
                   sh 'mvn test'
            }
        }
    }
}
