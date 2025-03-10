# Terminal Simulado - Trabalho Final de POO I

Este projeto é uma aplicação em modo texto que simula um terminal Linux, permitindo ao usuário executar comandos básicos como navegar entre diretórios, listar arquivos, criar e remover itens, e visualizar o histórico de comandos.

## Requisitos

- Java 8 ou superior
- Um terminal de comandos (cmd, PowerShell, Bash, etc.)

## Como Executar

1. Clone este repositório ou baixe os arquivos do projeto.
2. Compile o código-fonte com o seguinte comando:
   ```sh
   javac -d bin src/*.java
   ```
3. Execute a aplicação com:
   ```sh
   java -cp bin Terminal
   ```

## Comandos Disponíveis

O sistema suporta os seguintes comandos:

| Comando                  | Descrição |
|--------------------------|-----------|
| `pwd`                    | Exibe o diretório atual |
| `ls`                     | Lista os arquivos e diretórios do diretório atual |
| `cd <diretório>`         | Navega entre diretórios |
| `mkdir <nome>`           | Cria um novo diretório |
| `touch <arquivo>`        | Cria um novo arquivo vazio |
| `rm <arquivo/diretório>` | Remove um arquivo ou diretório |
| `cat <arquivo>`          | Exibe o conteúdo de um arquivo |
| `echo <texto> > <arquivo>` | Escreve texto em um arquivo |
| `history`                | Mostra o histórico de comandos digitados |
| `exit`                   | Encerra o programa |

## Estrutura do Código

O código está organizado nas seguintes classes:

- **Terminal**: Classe principal que inicia o programa e gerencia a entrada do usuário.
- **CommandHandler**: Responsável por interpretar e executar os comandos.
- **FileManager**: Gerencia a criação, leitura e remoção de arquivos.
- **DirectoryManager**: Manipula a navegação e criação de diretórios.

## Histórico de Comandos

O sistema armazena o histórico de comandos em um arquivo `.history.txt`, permitindo a recuperação de comandos digitados anteriormente.

## Contribuição

Caso queira melhorar o projeto, sinta-se à vontade para enviar um pull request ou sugerir mudanças!

## Licença

Este projeto foi desenvolvido para fins acadêmicos na disciplina de Programação Orientada a Objetos I.

