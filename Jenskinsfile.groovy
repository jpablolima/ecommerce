pipeline {
    agent {
        label  'ecommerce'
    }
    stages {
        stage ("build") {
            steps {
                echo "building the application..."
                sh  "/home/pablo/.nvm/versions/node/v20.17.0/bin/node -v"
                 sh  "ls -la"
        }
    }
    stage ("test") {
        steps {
            echo "test"
            //sh "docker builder prune -a -f"
            //sh "docker system prune -a -f"
        }
    }
    stage ("Build Image...") {
        steps {


            echo  "Criando imagem Docker do project..."
            sh  "docker images ecommerce"
           // sh  "docker build --no-cache -t ecommerce:latest ."
            sh  "docker images | grep ecommerce"
        }
    }
    stage ("Criando container e teste de execução..") {
        steps{
            sh  "docker rm -f ecommerce || true"
            sh  "docker run --rm ecommerce"
        }
    }
    stage("deploy") {
        steps {
            echo  "deploying the application..."
        }
    }
  }
}