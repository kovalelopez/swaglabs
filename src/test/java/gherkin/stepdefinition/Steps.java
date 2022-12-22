package gherkin.stepdefinition;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.HomePO;
import pageobjects.NetSalaryPO;
import pageobjects.ResultSalaryPO;

import static driver.Drivers.getDriver;

public class Steps {

    NetSalaryPO netSalary;
    ResultSalaryPO resultSalaryPO;
    HomePO home;

    @Given("eu acessei o site da Calculadora de salario liquido")
    public void eu_acessei_o_site_da_calculadora_de_salario_liquido() throws InterruptedException {
        netSalary = new NetSalaryPO(getDriver());
        resultSalaryPO = new ResultSalaryPO(getDriver());
        home = new HomePO(getDriver());
        home.getLaborCalculation("Ferramentas",
                "Calculadoras trabalhistas",
                "Salário Líquido");
    }

    @When("preencho o salario {string}")
    public void preencho_o_salario(String salary) {
        netSalary.setSalary(salary);
    }
    @When("preencho os descontos {string}")
    public void preencho_os_descontos(String discounts) {
        netSalary.setDiscounts(discounts);
    }
    @When("preencho o numero de dependentes {string}")
    public void preencho_o_numero_de_dependentes(String dependents) {
        netSalary.setDependents(dependents);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @When("efetuo o calculo")
    public void efetuo_o_calculo() {
        netSalary.btnCalculate();
    }

    @Then("eu tenho o valor {string} do salario liquido")
    public void eu_tenho_o_valor_do_salario_liquido(String netSalary) {
        resultSalaryPO.validateNetSalary(netSalary);
    }

}
