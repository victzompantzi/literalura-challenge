# LiterAlura Challenge
This command line program implements the public 'Gutendex' API and stores the results in a DB for querying 'Project Gutenberg' records

Alura Challenge - LiteraAlura - Oracle Next ONE G7 2024

<!-- Improved compatibility of back to top link: See: https://github.com/victzompantzi/encriptador/pull/73 -->

<a id="readme-top"></a>

[![LinkedIn][linkedin-shield]](https://www.linkedin.com/in/victortzompantzi/)

<!-- PROJECT LOGO -->
<br />
  <h3 align="center">LiteraAlura <i>Gutendex - Project Gutenberg</i></h3>

  <p align="center">
    Esta aplicación de consola consume la API pública de <a href="https://www.gutendex.com">Gutendex</a>, que permite acceder a los registros de libros del <b>Project Gutenberg</b> para realizar consultas. Las peticiones se realizan de una forma sencilla desde la interfaz del programa y presenta la respuesta en un formato adecuado si existen coincidencias. Además, almacena los registros en una base de datos relacional (PostgreSQL) y a partir estos, pueden realizarse más consultas desde la interfaz.
    <br />
    <br />
    <a href="https://github.com/victzompantzi/literalura-challenge/issues/new?labels=bug&template=bug-report---.md">Report Bug</a>
    <a href="https://github.com/victzompantzi/literalura-challenge/issues/new?labels=enhancement&template=feature-request---.md">Request Feature</a>
  </p>
</div>

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Tabla de Contenidos</summary>
  <ol>
    <li>
      <a href="#about-the-project">Sobre el proyecto</a>
      <ul>
        <li><a href="#built-with">Construido con...</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Comenzando</a>
      <ul>
        <li><a href="#prerequisites">Prerequisitos</a></li>
      </ul>
    </li>
    <li><a href="#usage">Uso</a></li>
    <li><a href="#contributing">Contribuir</a></li>
    <li><a href="#license">Licencia</a></li>
    <li><a href="#contact">Contacto</a></li>
  </ol>
</details>

<!-- Sobre el proyecto -->

## About the project

<div align="center">
  <img src="https://i.ibb.co/kH1S2wb/Screenshot-2024-12-28-200618.png" alt="product-screenshot">
</div>

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Project Demo

Watch the project demo video below:

<div align="center">
  <iframe width="560" height="315" src="https://www.veed.io/view/714b77f0-bebe-499c-be53-ea1d96066dcc" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Built with

Java 21 / Spring Boot / PostgreSQL

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- GETTING STARTED -->

## Getting Started

El programa te mostrará varias opciones auto-explicativas, pero vale la pena describir su funcionamiento. La primera opción hará las peticiones a la API para mostrar la información de la primera opción coincidente del libro buscado y, en caso contrario, mostrará el registro existente en la base de datos. El resto de las opciones te permitirán conocer la lista de los libros registrados, la lista de autores con sus libros registrados, los libros de autores vivos según el año especificado por el usuario y los libros registrados por idioma.

### Prerequisites

Java 21 o superior

[Runtime de Java](https://www.java.com/en/download/)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- USAGE EXAMPLES -->

## Usage

Descarga el repositorio y ejecuta desde tu IDE, editor o la terminal de tu preferencia, la siguiente clase: 'literalura-challenge\src\main\java\com\alura\literalura\LiteraluraApplication.java'

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- LICENSE -->

## License

Distributed under the MIT License. See `LICENSE.txt` for more information.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- CONTACT -->

## Contact

Víctor Tzompantzi - [@avistamientos.espirituales](https://instagram.com/avistamientos.espirituales)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->

[contributors-shield]: https://img.shields.io/github/contributors/othneildrew/Best-README-Template.svg?style=for-the-badge
[contributors-url]: https://github.com/victzompantzi/encriptador/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/othneildrew/Best-README-Template.svg?style=for-the-badge
[forks-url]: https://github.com/victzompantzi/encriptador/network/members
[stars-shield]: https://img.shields.io/github/stars/othneildrew/Best-README-Template.svg?style=for-the-badge
[stars-url]: https://github.com/victzompantzi/encriptador/stargazers
[issues-shield]: https://img.shields.io/github/issues/othneildrew/Best-README-Template.svg?style=for-the-badge
[issues-url]: https://github.com/victzompantzi/encriptador/issues
[license-shield]: https://img.shields.io/github/license/othneildrew/Best-README-Template.svg?style=for-the-badge
[license-url]: https://github.com/victzompantzi/encriptador/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://www.linkedin.com/in/victortzompantzi/
[product-screenshot]: assets/screenshot.png
[Next.js]: https://img.shields.io/badge/next.js-000000?style=for-the-badge&logo=nextdotjs&logoColor=white
[Next-url]: https://nextjs.org/
[React.js]: https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB
[React-url]: https://reactjs.org/
[Vue.js]: https://img.shields.io/badge/Vue.js-35495E?style=for-the-badge&logo=vuedotjs&logoColor=4FC08D
[Vue-url]: https://vuejs.org/
[Angular.io]: https://img.shields.io/badge/Angular-DD0031?style=for-the-badge&logo=angular&logoColor=white
[Angular-url]: https://angular.io/
[Svelte.dev]: https://img.shields.io/badge/Svelte-4A4A55?style=for-the-badge&logo=svelte&logoColor=FF3E00
[Svelte-url]: https://svelte.dev/
[Laravel.com]: https://img.shields.io/badge/Laravel-FF2D20?style=for-the-badge&logo=laravel&logoColor=white
[Laravel-url]: https://laravel.com
[Bootstrap.com]: https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white
[Bootstrap-url]: https://getbootstrap.com
[JQuery.com]: https://img.shields.io/badge/jQuery-0769AD?style=for-the-badge&logo=jquery&logoColor=white
[JQuery-url]: https://jquery.com