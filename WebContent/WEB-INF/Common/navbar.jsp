<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="index.html">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Retete
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="display-receipt-list.htm?typeId=1">Mic dejun</a>
          <a class="dropdown-item" href="display-receipt-list.htm?typeId=2">Supe</a>
          <a class="dropdown-item" href="display-receipt-list.htm?typeId=3">Fel principal</a>
          <a class="dropdown-item" href="display-receipt-list.htm?typeId=4">Desert</a>
          </div>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
         Editarea retetelor
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="add-receipt.htm">Adauga o reteta noua</a>
          <a class="dropdown-item" href="edit-receipt-list.htm">Editeaza o reteta</a>
          <a class="dropdown-item" href="delete-receipt-list.htm">Sterge o reteta</a>
          </div>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
         Editarea ingredientelor
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="input-ingredient.htm">Adauga un ingredient nou</a>
          <a class="dropdown-item" href="edit-ingredient.htm">Editeaza un ingredient</a>
          <a class="dropdown-item" href="sterge-ingredient.htm">Sterge un ingredient</a>
          </div>
      </li>
       <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
         Planificarea meniului saptamanal
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="display-week.htm">Afisarea meniului</a>
          <a class="dropdown-item" href="to-buy-list.htm">Lista de cumparaturi</a>
          </div>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0" action="search.htm?what=what">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="what">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>
