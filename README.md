# Locadora de Veículos
Este é um projeto de aplicação para gerenciar o aluguel de veículos, aplicando os conceitos vistos ao longo do módulo. A aplicação permite cadastrar, alterar, buscar e alugar veículos, bem como cadastrar e alterar clientes (pessoa física e jurídica) e gerenciar o processo de aluguel e devolução de veículos.

# Funcionalidades
## Veículos
* Cadastrar veículos: Permite o cadastro de novos veículos, garantindo que não sejam repetidos. Utiliza-se a placa como identificador de unicidade.
* Alterar veículo cadastrado: Possibilita a atualização das informações de um veículo já cadastrado.
* Buscar veículo por parte do nome: Permite a busca de um veículo pelo seu nome.
## Clientes
* Cadastrar cliente (pessoa física e jurídica): Permite o cadastro de clientes, garantindo que não sejam duplicados. Utiliza-se CPF (Pessoa Física) e CNPJ (Pessoa Jurídica) como identificadores de unicidade.
* Alterar cliente (pessoa física e jurídica): Possibilita a atualização das informações de um cliente já cadastrado.
## Aluguel e Devolução
* Alugar veículo para pessoa física e jurídica: Permite o processo de aluguel de veículos para clientes, registrando-se local, data e horário. Há uma exceção que impede que veículos indisponíveis sejam alugados.
* Devolver veículo para pessoa física e jurídica: Gerencia o processo de devolução de veículos, registrando-se local, data e horário, e aplicando descontos conforme as regras estabelecidas. Há uma exceção que impede que veículos já devolvidos sejam devolvidos novamente.
# Regras de Negócio
* Os veículos não podem ser repetidos, utiliza-se a placa como identificador de unicidade.
* Tipos de veículos considerados: PEQUENO, MÉDIO e SUV.
* Aluguéis e devoluções devem registrar o local, data e horário.
* Aluguel em horas quebradas é considerado uma diária completa.
* Veículos alugados não podem estar disponíveis.
* Clientes não podem ser duplicados, utiliza-se CPF (Pessoa Física) e CNPJ (Pessoa Jurídica) como identificadores de unicidade.
* Regras de devolução: 
<br>Cliente pessoa física com mais de 5 diárias tem direito a 5% de desconto. 
<br>Cliente pessoa jurídica com mais de 3 diárias tem direito a 10% de desconto.

# S.O.L.I.D
Exemplo dos cinco princípios do S.O.L.I.D usados para esse projeto:
* Princípio da Responsabilidade Única
<br>Exemplo de uso: as classes de cliente (PessoaFisica e PessoaJuridica) não possuem um método “alugar()”, isso violaria o princípio. Ao invés disso, existe a classe Aluguel, que é responsável por iniciar um aluguel e registrar seus dados; as classes de cliente apenas armazenam dados.

* Princípio Aberto-Fechado
<br>Exemplo de uso: existe a classe VeiculoComValorDiaria, que é uma extensão (com uso de composição) da classe Veiculo - a primeira é a que deve ser usada para a realização de um aluguel, a segunda apenas armazena dados.
 
* Princípio da Substituição de Liskov
<br>Exemplo de uso: a interface Cliente possui métodos comuns às classes de PessoaFisica e PessoaJuridica - os métodos “getIdentificador()” e “setIdentificador()” são utilizados na classe ClienteRepositoryInMemoryImpl, que generaliza os tipos de cliente. Um exemplo de violação desse princípio seria a existência de um método “getCpf()” na interface Cliente.

* Princípio da Segregação de Interfaces
<br>Exemplo de uso: as interfaces de calculadora possuem poucos ou apenas um método. 

* Princípio da Inversão de Dependência
<br>Exemplo de uso: a classe Caixa possui dois atributos - a princípio, ambos são apenas abstrações (interfaces), somente passam a ser concretos quando é instanciado um objeto dessa classe. Isto é, quando cria-se uma instância da classe Caixa, deve-se especificar os tipos de calculadora que serão usadas para a realização da cobrança da devolução de um aluguel.

# Design Patterns utilizados

* Builder 
<br>Exemplo de uso: nas classes Aluguel e Devolucao, existem “inner classes” chamadas Alugar e Devolver, respectivamente - elas são responsáveis por “construir” instâncias de Aluguel e Devolucao; aliás, essa é a única forma de instanciá-las, pois os construtores padrão de Aluguel e Devolucao têm o modificador de acesso “private”.

* Strategy 
<br>Exemplo de uso: o enum TipoVeiculo implementa métodos que calculam o valor da diária de um veículo, baseando-se no tipo (PEQUENO, MEDIO, SUV).

* Singleton 
<br>Exemplo de uso: das classes ClienteRepositoryInMemoryImpl e VeiculoRepositoryInMemoryImpl  é permitida apenas uma instância, e a única forma de instanciá-las é pelo método estático “getInstance()”.

# Extras

* O conceito de Generics foi pouco utilizado: na interface CrudRepository<T> e nas interfaces de calculadora - em que foi usada a classe Number.
* O pacote “exception/” possui exceções customizadas - ambas foram testadas em duas classes Main, no pacote “app/”.
