Feature: Revisar Factibilidad de Fibra Óptica para una dirección

  @Background:Me_dirijo_a_la_pagina_web_de_WOM
@Test
  Scenario Outline: Puedo navegar por la <seccion> a través de la barra de navegación
    Given estoy en la página principal de WOM
    When voy a "<seccion>" uso la barra de navegacion
    Examples:
      | seccion        |
      | Planes         |
      | Hogar          |
      | Equipos        |
      | Prepago        |
      | Internet Móvil |
      | Ayuda          |

  Scenario: La sección de planes se presenta correctamente
    When navego al menú Hogar y selecciono sub menu Revisa factibilidad
    And selecciono la opción de 600 MB
    And se despliega el formulario de factibilidad de fibra óptica
    Then la aplicación valida los datos ingresados y valida si tengo factibilidad

  Scenario: Selecciono la primera opción de Fibra óptica que me da la página y reviso si tengo factibilidad
    And selecciono el botón Quiero que me llamen
    And ingreso nombre y numero
    Then presiono botón Llámame