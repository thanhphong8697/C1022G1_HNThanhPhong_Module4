$(document).ready(function(){
    loadBlogs();
})

function loadBlogs( append){
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/blog`,
        headers: {
    "Content-Type": "application/json",
}
        ,
        success: function(data){
            debugger
            renderBlogs(data, append);
            rederLoadMoreButton(data);
        },
        error: function (error) {
            console.log(error);
        },
    });
}

function rederLoadMoreButton(blogPageData){
    if(blogPageData.number < blogPageData.totalPages - 1){
        $("#loadMoreContainer").html(
            `
            <button type = "button" class = "btn btn-secondary"
                onclick="loadMore(${blogPageData.number + 1})">
            </button>
            `
        );
    }else{
        $("#loadMoreContainer").remove();
    }
}

function loadMore(nextPage){
    loadBlogs(nextPage, true);
}

function renderBlogs(blogs, append){
    let elements = "";
    for(let blog of blogs.content){
        elements +=`
        <div class="card col-sm-3" style="width: 18rem;">
        <div class="card-body">
          <h5 class="card-title">${blog.title}</h5>
          <p class="card-text">${blog.author}</p>
          
          <a href="#" class="btn btn-primary">Read more</a>
        </div>
      </div>
        `;
    }
    if(append){
        $("#listBlogs").append(elements);
    }else{
        $("#listBlogs").html(elements);
    }
}