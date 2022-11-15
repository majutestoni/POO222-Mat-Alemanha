# Trabalho Final
Time: **Alemanha**
Alunos: **Jonathan Ribeiro, Maria Júlia Testoni e Martin Lange de Assis.**

### Fatures
| Data | Entrega |
| ------ | ------ |
| 17/11/2022 | -Composição da equipe -Definição da seleçãoe dados de ao menos 11 jogadores, 3 membros da comissão técnica, 2 dirigentes  –em arquivo texto.  -modelo de classes1UML de seu software-Lista dos conhecimentos de POO a serem desenvolvidos pela equipe(o que é preciso ainda aprender) –em arquivo texto.|

## Git

Segue um pouco de como trabalharemos com o git em nosso projeto
- instale o git https://git-scm.com/
- executar e estará ok
- existem alguns comandos de config para o git, mas passo via discord

#### Projeto em sua maquina
- criar uma pasta em seu computador 
- abrir um terminal git bash na mesma (com o botão direito)
- dar o comando

```sh
git clone https://github.com/majutestoni/POO222-Mat-Alemanha.git
```

#### Trabalhando com branch (by Maju)
- sempre acessar a main para começar a trabalhar
- na main
```sh
git pull
```

- criando branch

> usaremos um padrão feature/seunome-numero++

```sh
git checkout -b feature/maju-1
```

- para mudar de branch
```sh
git checkout feature/maju-1
```
```sh
git checkout main
```
- após fazer as alterações desejadas e queira unir ao projeto
```sh
git add.
```
> padrão do commit "[branch] o que foi feito"
```sh
git commit -m "[feature/maju-1] alterada classe aluno e professor"
```
```sh
git push
```
- no github terá a solicitação do merge e as alterações feitas
- posso fazer a code review e aceitar o merge, que será feito na main
- por isso, ao começar a trabalhar em uma nova branch sempre dar pull na main para atualizar


