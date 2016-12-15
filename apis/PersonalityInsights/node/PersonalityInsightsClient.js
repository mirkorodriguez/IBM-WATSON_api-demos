'use strict';

var PersonalityInsights = require('watson-developer-cloud/personality-insights/v2');
var fs = require('fs');

var personality_insights = new PersonalityInsights({
  username: '842a005c-8baa-4e4e-a2f2-a915e89fd185',
  password: 'zLSpcxCsfAqk',
  version_date: '2016-10-19'
});


/*
 * Spanish example:
 *   'text' parameter contains the input text.
 */
 personality_insights.profile({
   text: 'La reacción instantánea de los mercados financieros a la elección de Donald Trump como próximo presidente de los Estados Unidos fue de sorpresa, pero al final del día ya se habían recuperado. Desde entonces los principales índices de la bolsa norteamericana han subido un 3%; la bolsa de Japón, otro tanto; las bolsas europeas, un poco menos. Lo mismo ha pasado con los metales, especialmente el cobre, que ha subido casi 20%, y con el petróleo.' +
         'El motivo de tanta euforia (o, en todo caso, uno de ellos) es el plan de infraestructura de Trump. Más que un plan, es una visión: miles de puentes reparados; miles de nuevas redes de agua; miles de empleos en la industria de la construcción, en la manufactura de acero y en otros sectores. “Una oportunidad de oro”, dice su página web, “para acelerar el crecimiento económico.' +
         'Trump apunta a cubrir las necesidades de infraestructura para los próximos diez años, que la National Association of Manufacturers estima en un billón de dólares. Todo con inversión privada… y una ayudita de su amigo. Aquí es donde uno comienza a pensar que el plan no es necesariamente bueno para los Estados Unidos.' +
         'La idea es la siguiente. Las empresas que inviertan en infraestructura recibirán un crédito tributario equivalente al 82% de su inversión, de acuerdo con un análisis publicado por el inversionista Wilbur Ross y el profesor Peter Navarro de la Universidad de California, Irvine, ambos asesores de la campaña de Trump. El crédito tributario servirá para moderar las expectativas de rentabilidad de los inversionistas, haciendo viables proyectos que, de otro modo, no se ejecutarían. El gobierno recuperará el crédito tributario con los impuestos a las utilidades de los contratistas y a las remuneraciones de los trabajadores empleados en la construcción. Ambos puntos descansan en un razonamiento económico equivocado.' +
         'El crédito tributario ciertamente reduce la expectativa de rentabilidad del inversionista, pero la reduce única y exclusivamente porque la mayor parte de la plata que invierte no es suya, sino del gobierno. El inversionista no se hace problema si el gobierno le devuelve el 82% de su inversión mediante una reducción de impuestos para sus otros negocios. Y en tanto no es plata suya, no necesita que el proyecto le deje suficientes ganancias para remunerarla. Pero al gobierno sí debería interesarle, porque la plata que indirectamente le facilita al inversionista podría utilizarse para otras cosas que el público norteamericano quizás juzgaría tan o más valiosas que, digamos, un puente en Alaska.' +
         'De otro lado, la posibilidad (mas no la certeza) de que el crédito tributario sea recuperado con los impuestos futuros no implica, como erróneamente sostiene Trump, que su plan no tenga un impacto en la recaudación y el déficit fiscal. La razón es muy simple: si el proyecto se ejecutara sin crédito fiscal, el gobierno igual cobraría esos impuestos. Siempre se puede decir que sin el crédito fiscal el proyecto no se ejecutaría y el gobierno nunca recaudaría esos impuestos; pero esa lógica (o falta de) es igualmente aplicable a la infraestructura como a cualquier otra clase de inversión.' +
         'Por lo que hasta ahora sabemos, el plan de infraestructura de Trump no garantiza que se construya la infraestructura que los Estados Unidos más necesitan y su costo fiscal será enorme. ' +
         'Los sistemas políticos europeos no han sido los únicos sacudidos por la crisis. Aunque en Estados Unidos pervive la vieja bicefalia entre demócratas y republicanos, un terremoto de heterodoxia —de la que Trump es la muestra más visible, pero no la única— ha dejado atónitos a los analistas políticos. Quizá nos sorprenda menos a los europeos: el estilo directo y populista en el discurso de Trump, muy alejado del habitual tono de los políticos, le ha conferido a una pátina de autenticidad a ojos del sector más desencantado del electorado de la derecha. Los analistas políticos hacen cábalas y han elaborado hipótesis de lo más variopinto para explicar su éxito. Por un lado resulta obvio que el mensaje de Trump es populista, maniqueo y reduccionista. ' +
         'Parece guiarse por la vieja máxima de perseguir que se hable de él, aunque sea mal',
   language: 'es',
   accept_language: 'es'},
   function (err, response) {
     if (err)
       console.log('error:', err);
     else
       console.log(JSON.stringify(response, null, 2));
 });
