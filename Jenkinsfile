pipeline{

agent any
  
  stages{
  
    stage('Complie Stage'){
      Steps{
        withMaven(Maven : 'maven_3_6_3'){
        sh 'mvn clean compile'
        }      
      }
    
        stage('Testing Stage'){
      Steps{
        withMaven(Maven : 'maven_3_6_3'){
        sh 'mvn test'
        }
      
      }
    
    } 
  
  }

}
