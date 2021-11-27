function fillEmploymentHistory ()
{
    var begindate = document.getElementById("begindate");
    var enddate = document.getElementById("enddate");
    var jobDesc = document.getElementById("jobDesc");
    
    var emph = document.getElementById("emphlist").value;
    begindate.value = "emph.getBeginDate()";
    enddate.value = emph.getEndDate();
    jobDesc.value = emph.getJobDescription();
}