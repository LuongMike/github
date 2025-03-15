<%@page import="dto.BookDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Book Catalog - Book Management System</title>
        <link rel="stylesheet" href="assets/css/index.css">
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        
        <div class="page-content">
            <div class="catalog-header">
                <h1>Book Catalog</h1>
                <div class="search-container">
                    <form action="MainController" method="GET">
                        <input type="hidden" name="action" value="listBooks">
                        <input type="text" name="searchTerm" placeholder="Search by title, author..." value="<%= request.getParameter("searchTerm") != null ? request.getParameter("searchTerm") : "" %>">
                        <button type="submit" class="search-button">Search</button>
                    </form>
                </div>
            </div>
            
            <% String message = (String) request.getAttribute("message"); %>
            <% if (message != null) { %>
                <div class="message-container <%= request.getAttribute("messageType") %>">
                    <p><%= message %></p>
                </div>
            <% } %>
            
            <div class="books-container">
                <% List<BookDTO> bookList = (List<BookDTO>) request.getAttribute("bookList"); %>
                <% if (bookList == null || bookList.isEmpty()) { %>
                    <div class="no-results">
                        <p>No books found. Please try a different search or check back later.</p>
                    </div>
                <% } else { %>
                    <div class="book-grid">
                        <% for (BookDTO book : bookList) { %>
                            <div class="book-card">
                                <div class="book-cover">
                                    <% if (book.getImage() != null && !book.getImage().isEmpty()) { %>
                                        <img src="<%= book.getImage() %>" alt="<%= book.getTitle() %>" onerror="this.onerror=null; this.src='assets/images/no-cover.png';">
                                    <% } else { %>
                                        <div class="no-image">
                                            <span>No Cover</span>
                                        </div>
                                    <% } %>
                                </div>
                                <div class="book-info">
                                    <h3 class="book-title"><%= book.getTitle() %></h3>
                                    <p class="book-author">by <%= book.getAuthor() %></p>
                                    <p class="book-year">Published: <%= book.getPublishYear() %></p>
                                    <div class="book-price-container">
                                        <span class="book-price">$<%= book.getPrice() %></span>
                                        <% if (book.getQuantity() > 0) { %>
                                            <span class="stock in-stock"><%= book.getQuantity() %> in stock</span>
                                        <% } else { %>
                                            <span class="stock out-of-stock">Out of stock</span>
                                        <% } %>
                                    </div>
                                    <a href="MainController?action=viewDetail&id=<%= book.getBookID() %>" class="view-details-btn">View Details</a>
                                </div>
                            </div>
                        <% } %>
                    </div>
                    
                    <!-- Pagination -->
                    <% Integer currentPage = (Integer) request.getAttribute("currentPage");
                       Integer totalPages = (Integer) request.getAttribute("totalPages"); %>
                    <div class="pagination">
                        <% if (currentPage != null && totalPages != null) { %>
                            <% if (currentPage > 1) { %>
                                <a href="MainController?action=listBooks&page=<%= currentPage - 1 %>&searchTerm=<%= request.getParameter("searchTerm") %>" class="pagination-btn">&laquo; Previous</a>
                            <% } %>
                            <div class="pagination-info">
                                Page <%= currentPage %> of <%= totalPages %>
                            </div>
                            <% if (currentPage < totalPages) { %>
                                <a href="MainController?action=listBooks&page=<%= currentPage + 1 %>&searchTerm=<%= request.getParameter("searchTerm") %>" class="pagination-btn">Next &raquo;</a>
                            <% } %>
                        <% } %>
                    </div>
                <% } %>
            </div>
        </div>
        
        <jsp:include page="footer.jsp"/>
        
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <script src="assets/js/index.js"></script>
    </body>
</html>
