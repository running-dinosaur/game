pipeline {

   agent any
   
   stages {
      stage('拉取代码'){
         steps {
            git 'https://github.com/running-dinosaur/game.git'
         }
      }

      stage('构建'){
         steps {
            // Run the maven build
            sh "mvn clean deploy"
         }
      }
      
      stage('部署'){
         steps {
            echo "deploy"
         }
      }
   }
   
   post {
       always {
			junit testResults: "**/target/surefire-reports/TEST-*.xml"
			archiveArtifacts artifacts: '**/target/*.jar,**/target/*.war'
       }
   }
   
}