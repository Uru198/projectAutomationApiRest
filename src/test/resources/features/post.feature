#author: Andres Uruburu Berrio
#language: es


Característica: Consumo con serenity-rest el verbos POST

  Yo como Andres
  Quiero realizar consumos a un servicio de apirest de tipo post
  Para comprobar la robustes de esta y validar si envia los datos

  Antecedentes:
    Dado "Andres" obtiene la baseurl de la api

  @Successful
  Escenario: Enviar(post) los datos que arroje el consumo de la api
    Cuando configura la solicitud a consumir
    Entonces valida los datos consultados