# 💼 HaVagas — App de Cadastro para Oportunidades de Emprego  
Aplicativo simples de cadastro de usuários interessados em vagas de trabalho, desenvolvido com foco em boas práticas de UI e lógica de formulários.

![HaVagas](image/capa.png)

---

## 🙋‍♀️ Sobre o projeto

Esse app foi desenvolvido como parte da disciplina **Programação para Dispositivos Móveis** no **IFSP - São Carlos**.  
O objetivo foi aplicar conceitos de interface, componentes dinâmicos e validação de dados em um formulário completo.

---

## ✨ O que ele faz

- Cadastro de nome, e-mail, telefone e celular  
- Opção para receber atualizações por e-mail  
- Identificação do tipo de telefone (comercial ou residencial)  
- Campos dinâmicos para celular e formação acadêmica  
- Seleção de sexo e data de nascimento  
- Campo aberto para vagas de interesse  
- Botões de salvar (com pop-up de resumo) e limpar formulário

---

## ⚙️ Tecnologias usadas

- **Kotlin** — linguagem principal  
- **ViewBinding** — para facilitar a ligação entre layout e código  
- **Componentes de UI do Android Studio** — como `EditText`, `RadioButton`, `CheckBox`, `Spinner`, `DatePicker`, entre outros

---

## 📂 Estrutura básica

Toda a lógica está na `MainActivity.kt`.  
Os campos são exibidos ou ocultados dinamicamente conforme as seleções do usuário.  
Ao clicar em **Salvar**, os dados preenchidos são exibidos em um `Toast` ou `AlertDialog` para confirmação.

---

## 🧪 Como testar

1. Clone o repositório:  
   ```bash
   git clone https://github.com/seu-usuario/havagas-app.git
