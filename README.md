# Desafio-consulta-vendas

Este projeto é um sistema de vendas (Sale) e vendedores (Seller). Cada venda está para um vendedor, e um
vendedor pode ter várias vendas.

Neste projeto implementei a JPA com consultas customizadas SQL e JPQL.

__________________Relatório de Vendas_______________

1. O usuário informa, opcionalmente, data inicial, data final e um trecho do nome do vendedor.

O sistema retorna uma listagem paginada contendo id, data, quantia vendida e nome do
vendedor, das vendas que se enquadrem nos dados informados.


__________________Sumário de vendas por vendedor_______________

1. O usuário informa, opcionalmente, data inicial, data final.

O sistema retorna uma listagem contendo nome do vendedor e soma de vendas deste vendedor
no período informado.

![Consulta vendas](https://github.com/DennerOl/Desafio-consulta-vendas/assets/124217386/a40f88cc-05e8-41fd-8891-79b1d457340a)

______________________________________________________________________________________________________________________


GET /sales/summary?minDate=2022-01-01&maxDate=2022-06-30
---->Retorna o sumário de vendas por vendedor no período informado

GET /sales/summary
---->Retorna o sumário de vendas por vendedor dos últimos 12 meses.

GET /sales/report
---->Retorna o relatório de vendas dos últimos 12 meses.

GET /sales/report?minDate=2022-05-01&maxDate=2022-05-31&name=odinson
---->Retorna o relatório de vendas do período/vendedor informados:


