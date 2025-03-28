pipeline {
    agent any

    environment {
        DOCKER_CREDENTIALS = credentials('dockerhub-credentials')
    }
    // every 1 minutes
    triggers {
            pollSCM('* * * * *')
    }
    stages{

        // Stage 1: Build and Package Microservices
        stage('Build and Package Microservices in staging branch') {
            when {
                branch 'staging'
            }
            steps {
                git branch: 'staging', url: 'https://github.com/nmtndl2/java-jenkins-docker.git'
                script {
                    try{
                        def services = ['QuizService', 'QuestionService', 'ApiGateway', 'ServiceRegistry']
                        services.each { service ->
                            bat """
                                cd MicroService-webClient-docker/${service}
                                mvn clean package -DskipTests
                                cd ../..
                            """
                        }
                    } catch(Exception e) {
                       echo "Build failed: ${e.message}"
                       error("Stopping pipeline due to build failure!")
                    }
                }
            }
        }

        // Stage 2: Build and Package Microservices in main branch
        stage('Build and Package Microservices in main branch') {
            when {
                branch 'main'
            }
            steps {
                git branch: 'main', url: 'https://github.com/nmtndl2/java-jenkins-docker.git'
                script {
                    try{
                        def services = ['QuizService', 'QuestionService', 'ApiGateway', 'ServiceRegistry']
                        services.each { service ->
                            bat """
                                cd MicroService-webClient-docker/${service}
                                mvn clean package -DskipTests
                                cd ../..
                            """
                        }
                    } catch(Exception e) {
                       echo "Build failed: ${e.message}"
                       error("Stopping pipeline due to build failure!")
                    }
                }
            }
        }

        // Stage 3: Login to Docker Hub
        stage('Login to Docker Hub') {
            steps {
                script {
                    try {
                        withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials', usernameVariable: 'DOCKER_HUB_USER', passwordVariable: 'DOCKER_HUB_PASS')]) {
                            bat """
                                docker login -u %DOCKER_CREDENTIALS_USR% -p %DOCKER_CREDENTIALS_PSW%
                            """
                        }
                    } catch(Exception e) {
                         echo "Login failed: ${e.message}"
                         error("Stopping pipeline due to Docker login failure!")
                    }
                }
            }
        }

        // Stage 4: Build and Run Docker Containers using Docker-Compose
        stage('Compose up docker-compose file in staging branch') {
            when {
                branch 'staging'
            }
            steps {
                script {
                    try{
                        bat """
                            cd MicroService-webClient-docker
                            docker-compose down -v
                            docker-compose up --build -d
                            cd ../..
                        """
                    } catch(Exception e) {
                        echo "Docker compose failed: ${e.message}"
                        error("Stopping pipeline due to Docker Compose failure!")
                    }
                }
            }
        }

        // Stage 5: Build and Run Docker Containers using Docker-Compose in main branch
        stage('Merge staging to main in main branch') {
            when {
                branch 'main'
            }
            steps {
                git branch: 'main', url: 'https://github.com/nmtndl2/java-jenkins-docker.git'
                script {
                    try{
                        bat """
                            cd MicroService-webClient-docker
                            docker-compose down -v
                            docker-compose up --build -d
                            cd ../..
                        """
                    } catch(Exception e) {
                        echo "Docker compose failed: ${e.message}"
                        error("Stopping pipeline due to Docker Compose failure!")
                    }
                }
            }
        }
    }

    // Post-build cleanup stage (Executed regardless of build status)
    post {
        always {
            echo 'Cleaning up...'
            cleanWs()
        }
    }
}