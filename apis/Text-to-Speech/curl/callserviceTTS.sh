# {
#   "url": "https://stream.watsonplatform.net/text-to-speech/api",
#   "username": "fa51a9fd-2fd9-4bb3-8f96-ed63678e9338",
#   "password": "fBEgtEydZCiK"
# }

# Voice synthesis
# es-ES_EnriqueVoice
# es-ES_LauraVoice
# es-LA_SofiaVoice
# es-US_SofiaVoice

# Example GET request  Show Runnable
curl -X GET -u "82eed693-2595-4b51-9e7d-e126ae37a214":"U6SXETFzMW3x" \
--output hello_world_get.wav \
"https://stream.watsonplatform.net/text-to-speech/api/v1/synthesize?accept=audio/wav&text=Hello%20world&voice=en-US_AllisonVoice"


curl -X GET -u "82eed693-2595-4b51-9e7d-e126ae37a214":"U6SXETFzMW3x" \
--output audio_test.wav \
"https://stream.watsonplatform.net/text-to-speech/api/v1/synthesize?accept=audio/wav&text=%3Cp%3E%3Cs%3EHe%20sido%20seleccionado%20para%20manejar%20su%20orden%3Cbreak%20time%3D%22500ms%22%2F%3E.%20Lamento%20decirle%20que%20los%20productos%20seleccionados%20no%20se%20encuentran%20disponibles.%20%3Cprosody%20rate%3D%22-15%25%22%3ENo%20sabemos%20cu%C3%A1ndo%20lo%20estar%C3%A1n%20reponiendo.%20quiz%C3%A1s%20la%20pr%C3%B3xima%20semana%3C%2Fprosody%3E%3Cbreak%20time%3D%22500ms%22%2F%3E%20Porque%20queremos%20que%20sea%20un%20cliente%20satisfecho%2C%20hemos%20decidido%20%3Cemphasis%20level%3D%22strong%22%3Edarle%20un%2040%25%20de%20descuento&voice=es-ES_EnriqueVoice"



# Example POST request  Show Runnable
curl -X POST -u "fa51a9fd-2fd9-4bb3-8f96-ed63678e9338":"fBEgtEydZCiK" \
--header "Content-Type: application/json" \
--header "Accept: audio/wav" \
--data "{\"text\":\"Hola Mirko Cómo estas?\"}" \
--output hola_spanish_enrique.wav \
"https://stream.watsonplatform.net/text-to-speech/api/v1/synthesize?voice=es-ES_EnriqueVoice"


curl -X POST -u "fa51a9fd-2fd9-4bb3-8f96-ed63678e9338":"fBEgtEydZCiK" \
--header "Content-Type: application/json" \
--header "Accept: audio/wav" \
--data "{\"text\":\"El Arte de la Guerra – Sun Tzu - Capítulo 1. \
Contenido Gratuito, Audiolibro Alojado en IGETAX, Registrate y accede a más contenido. \
Sobre la evaluación. \
La guerra es de vital importancia para el Estado; es el dominio de la vida o de la muerte, el camino hacia la supervivencia o la pérdida del Imperio: es forzoso manejarla bien. No reflexionar seriamente sobre todo lo que le concierne es dar prueba de una culpable indiferencia en lo que respecta a la conservación o pérdida de lo que nos es más querido; y ello no debe ocurrir entre nosotros. \
\"}" \
--output textolibro_enrique.wav \
"https://stream.watsonplatform.net/text-to-speech/api/v1/synthesize?voice=es-ES_EnriqueVoice"


curl -X POST -u "82eed693-2595-4b51-9e7d-e126ae37a214":"U6SXETFzMW3x" \
--header "Content-Type: application/json" \
--header "Accept: audio/wav" \
--data "{\"text\":\"<p><s>He sido seleccionado para manejar su orden<break time='500ms'/>. \
Lamento decirle que los productos seleccionados no se encuentran disponibles. \
<prosody rate='-15%'>No sabemos cuándo lo estarán reponiendo, quizás la próxima semana.</prosody><break time='500ms'/> \
Porque queremos que sea un cliente satisfecho, hemos decidido <emphasis level='strong'>darle un 40% de descuento! </emphasis></s></p>  \"}" \
--output descuento_test.wav \
"https://stream.watsonplatform.net/text-to-speech/api/v1/synthesize?voice=es-ES_EnriqueVoice"
