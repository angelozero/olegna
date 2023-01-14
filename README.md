# Projeto Olegna

## Artigo - Do Zero a Produção com Spring Boot e AWS

---

### Capítulo 01: Hello World

**Fazendo o primeiro deploy com AWS**

Iniciaremos pela famosa plataforma de nuvem chamada [AWS](https://aws.amazon.com/pt/what-is-aws/). Será necessário criar uma conta e após a criação vamos precisar de algumas informações. A primeira é o **AWS Access Key ID** e a segunda **AWS Secret Access Key**. Para acessa-lás esteja _logado_ e siga este caminho.

- No menu superior clique em:  
    -   ```shell
            NOME_DA_SUA_CONTA > Credenciais de Segurança > Chaves de Acesso 
        ```

Agora vamos instalar um recurso da AWS chamado [AWS Command Line Interface](https://aws.amazon.com/pt/cli/) ou o famoso **CLI**. 

**Instalando e configurando o AWS CLI**
- Acesse [CLI](https://docs.aws.amazon.com/cli/latest/userguide/getting-started-install.html) para download.
- Após a instalação, em seu terminal digite: `aws configure`
- Na opção `Default region name` selecione a região que está a sua conta: _Ex.:"us-east-1"_
- Na opçãp `Default output format`: digite `json` ou `yaml`
- Se tudo estiver configurado corretamente, digite no seu terminal `aws ec2 describe-regions` e você deverá receber um longo texto (no formato que você definiu) com as descrições das regiões.

- ![aw_configure](https://i.postimg.cc/05bLLWSw/Screen-Shot-2023-01-14-at-19-14-16.png)

**Criando nossa aplicação Java**

Inicialmente vamos criar um simples projeto web java. Ele terá apenas um _controller_. Para a criação deste projeto vamos utilizar o [Spring Initializr](https://start.spring.io/). Segue as configurações mais importantes, as demais você escolher da maneira como preferir:

- **Project**: Maven
- **Language**: Java
- **Spring** Boot: 3.0.1
- **Packaging**: Jar
- **Java**: 11
- **Dependencies**: Spring Web

![spring_init](https://i.postimg.cc/TwqXhpRW/Whats-App-Image-2023-01-14-at-16-40-51.jpg)


Esta aplicação por enquanto vai ter apenas um _controller_. Subindo a aplicação e fazendo uma requisição para `http://localhost:8080/` você deve receber um `"OK"` na tela do seu navegador.
A implementação para este _controller_ fica assim:

```java
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    @GetMapping("/")
    public String simpleRequest() {
        return "OK";
    }
}
```

**Publicando a aplicação no Docker Hub**

_OBS.: O ponto aqui vai partir com o [Docker](https://docs.docker.com/engine/install/) configurado em sua máquina e com sue usuário criado no [Docker Hub](https://hub.docker.com/)._

Após a aplicação estar rodando vamos criar uma imagem dela e subir no repositório do Docker Hub. Primeiro vamos gerar o `.jar` da aplicação, para isso adicione a seguinte linha no seu arquivo `pom`.
-   ```xml
    	<build>
		<!-- some plugins configurations here-->

		<finalName>olegna-docker</finalName>
	</build>
    ```
Agora crie um arquivo chamado `Dockerfile` ( com a letra "D" em maiúsculo ) e nele adicione as seguintes informações:

```sql
FROM openjdk:17
EXPOSE 8080
ADD target/olegna-docker.jar olegna-docker.jar
ENTRYPOINT ["java", "-jar", "/olegna-docker.jar"]
```

_Builde_ e rode novamente o Maven ( `mvn clean install` ) no seu projeto para que seja gerado o `.jar`.

Feito isso vamos testar para ver se nossa imagem está funcionando. 

---

parei aqui ---> Publishing the “Hello World” App to Docker Hub
- [Docker - Dockerizing your Spring Boot Application | Java Techie](https://www.youtube.com/watch?v=e3YERpG2rMs)
- [How to Push and Pull a Docker Image from Docker Hub](https://www.youtube.com/watch?v=EIHY_CY5J0k)