<h1>Link Like</h1>

<g:form name="linkCreateForm" url="[action:'create']">
  Title: <g:textField name="title"/><br/>
  URL: <g:textField name="url"/><br/>
 
  

  <input type="submit" value="Add new link"/>


</g:form>

<hr>

<ul>
  <% if(links.size() == 0) { %>
    <li>No links</li>
  <% } else { %>
    <% for(link in links) { %>
      <li>
        <g:form name="LikeForm" url="[action:'liking']">
          <a href=<%=link.url%>><%= link.title %></a>
          
          <g:hiddenField name="url" value="${link.url}"/>
          <input type="submit" value="LIKE !"/> Like = <%=link.liker%>
        </g:form>
      </li>
    <% } %>
  <% } %>
</ul>