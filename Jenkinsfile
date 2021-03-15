pipeline {
        agent any 
        stages {
            stage ('Build Backend'){
                steps {
                    bat 'mvn clean package -DskipTests=true'
                }
            }
            stage ('Unit Tests'){
                steps {
                    bat 'mvn test'
                }
            }
            stage ('Deploy Backend'){
                steps {
                    git 'https://github.com/LeviSilvaz99/tasks-backend.git '
                    deploy adapters: [tomcat8(credentialsId: 'TomcatLogin', path: '', url: 'http://localhost:8001/')], contextPath: 'tasks-backend', war: 'target/tasks-backend.war'
                }
            }
            stage ('API Test') {
                steps{
                    dir('api-test'){
                        git 'https://github.com/LeviSilvaz99/api-test-tasks.git'
                        bat 'mvn test'
                    }
                   
                }
            }

            stage ('Deploy Frontend'){
                steps {
                    dir('frontend'){
                        git 'https://github.com/LeviSilvaz99/tasks-frontend.git'
                        bat 'mvn clean package'
                        deploy adapters: [tomcat8(credentialsId: 'TomcatLogin', path: '', url: 'http://localhost:8001/')], contextPath: 'tasks', war: 'target/tasks.war'
                    }
                }
            }
            
        }
        post {
            aways {
                junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml, APITet/target/surefire-reports/*.xml'
            }
        }
    
}


