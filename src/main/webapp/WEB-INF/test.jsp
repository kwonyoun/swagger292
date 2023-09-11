<div class="container">
    <h1>Responsive Table</h1>
      <table class="rwd-table">
        <tbody>
          <tr>
            <th>번호</th>
            <th>제목</th>
            <th>질문자</th>
            <th>공개여부</th>
            <th>문의일</th>
          </tr>
          <c:forEach var="item" items="${vo}">
          <tr>
            <td data-th="Supplier Code">
                ${item.qnaNum}
            </td>
            <td data-th="Supplier Name">
                <a href="/cscenter/qna/view?qnaNum=${item.qnaNum}">${item.qnaTitle}
                    <c:if test="${item.qnaOpen eq 'private'}">
                    <img src="/imgs/lock.png" alt="fail" style="width: 12px; height: 12px;" >
                    </c:if>
                 </a>
            </td>
            <td data-th="Invoice Number">
                ${item.qnaMemId}
            </td>
            <td data-th="Invoice Date">
                ${item.qnaOpen}
            </td>
            <td data-th="Due Date">
                ${item.qnaDate}
            </td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    <h3>Resize Me</h3>
</div>