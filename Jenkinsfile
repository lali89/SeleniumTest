pipeline { 
    agent any  
    stages { 
        stage('Build') { 
            steps { 
               echo 'This is a minimal pipeline.' 
                sh "cd TestSelniumPipeline"
                   sh 'mvn test'
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
