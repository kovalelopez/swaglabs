
  Feature: Calculadora de salario liquido
    Eu como funcionario da modalidade CLT
    Quero acessar calcular meu salario liquido
    Para saber o salario liquido e os descontos

    Background:
      Given eu acessei o site da Calculadora de salario liquido

    Scenario Outline: Net salary calculation
      When preencho o salario <salario>
      And preencho os descontos <descontos>
      And preencho o numero de dependentes <dependentes>
      * efetuo o calculo
      Then eu tenho o valor <valor> do salario liquido
      Examples:
      |salario    |descontos   |dependentes|valor      |
      |"1000,00"  |"0,00"      |"0"        |"R$ 925,00"|