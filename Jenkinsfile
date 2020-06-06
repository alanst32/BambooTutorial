pipeline {
    environment {
        registry = "skoogle/skoogle-desktop"
        registryCredential = 'dockerhub'
        dockerHubImage = 'skoogle-desktop:0.0.1-SNAPSHOT'
        dockerImage = 'skoogle-desktop:0.0.1-SNAPSHOT'
    }
    agent any
    stages {
        stage('Gradle Build') {
            steps {
                sh './gradlew clean build'
            }
        }
        stage('Test'){
            steps {
                sh './gradlew test'
            }
        }
        stage('Building image') {
            steps {
                sh './gradlew docker'
            }
        }
        stage('Push image') {
            steps {
                withCredentials( [usernamePassword(credentialsId: registryCredential, usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')] ) {
                        sh "docker login -u ${USERNAME} -p ${PASSWORD}"
                        sh 'docker tag skoogle-desktop:0.0.1-SNAPSHOT skoogle-desktop/skoogle-desktop:0.0.1-SNAPSHOT'
                        sh 'docker push skoogle-desktop:0.0.1-SNAPSHOT'

                }
            }
        }
        stage('Remove unused docker image') {
            steps {
                sh 'docker rmi ' + dockerImage
            }
        }
    }
}