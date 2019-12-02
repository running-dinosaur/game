pipeline {

	agent any
   
   	options {
		//设置保存最近历史构建记录的数量
		buildDiscarder(logRotator(numToKeepStr: '3'))
		//禁止多个pipeline并行执行
		disableConcurrentBuilds()
   	}

   
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
				sh "printenv"
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
       	failure {
//           	mail to: 'yanyingjun@airchina.com', subject: 'The Pipeline failed :('
       	}

   	}
}