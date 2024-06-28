#author: Andres Uruburu Berrio
#language: es

Característica: Consumo con serenity-rest el verbos GET

  Yo como Andres
  Quiero realizar consumos a un servicio de apirest de tipo get
  Para comprobar la robustes de esta y validar si consulta los datos

  Antecedentes:
    Dado "Andres" obtiene la baseurl de la api

  @Successful
  Escenario: Obtener(get) los datos que arroje el consumo de la api
    Cuando configura la peticion a consumir
    Entonces valida estado de la peticion