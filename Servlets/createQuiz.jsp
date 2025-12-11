<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Quiz</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/createQuiz.css">
</head>
<body>

<h2>Create a New Quiz</h2>

<form action="<%= request.getContextPath() %>/CreateQuizServlet" method="post">

    <label>Quiz Name:</label>
    <input type="text" name="quizName" required>

    <label>Description:</label>
    <textarea name="description" rows="3"></textarea>

    <label>Category:</label>
    <input type="text" name="category">

    <h3 style="color:#1a4b9a;">Enter Questions</h3>

    <div id="questions-container">
        <div class="question-block">
            <label>Question Text:</label>
            <input type="text" name="questionText[]" required>

            <label>Option A:</label>
            <input type="text" name="optionA[]" required>

            <label>Option B:</label>
            <input type="text" name="optionB[]" required>

            <label>Option C:</label>
            <input type="text" name="optionC[]" required>

            <label>Option D:</label>
            <input type="text" name="optionD[]" required>

            <label>Correct Option:</label>
            <select name="correctOption[]">
                <option value="A">A</option>
                <option value="B">B</option>
                <option value="C">C</option>
                <option value="D">D</option>
            </select>
        </div>
    </div>

    <button type="button" onclick="addQuestion()">Add Another Question</button>
    <br><br>

    <button type="submit">Save Quiz</button>
</form>

<script>
function addQuestion() {
    let container = document.getElementById("questions-container");
    let block = document.querySelector(".question-block").cloneNode(true);

    // clear inputs
    block.querySelectorAll("input").forEach(i => i.value = "");
    
    container.appendChild(block);
}
</script>

</body>
</html>
