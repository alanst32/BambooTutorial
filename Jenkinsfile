pipeline {
    environment {
        registry = "skoogle/skoogle-desktop"
        registryCredential = 'dockerhub'
        dockerHubConfig = 'skoogle/skoogle-desktop:0.0.1-SNAPSHOT'
        dockerImage = skoogle-desktop:0.0.1-SNAPSHOT'
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
                sh 'docker tag ' + dockerImage + ' ' + dockerHubConfig
            }
        }
        stage('Push image') {
            steps {
                script {
                    withDockerRegistry([credentialsId: registryCredential, url: 'https://registry.hub.docker.com']) {
                        sh 'docker push skoogle/' + dockerImage
                    }
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