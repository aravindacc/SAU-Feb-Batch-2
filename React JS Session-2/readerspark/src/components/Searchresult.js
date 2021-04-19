import React from "react";

const Details = (props) => {
  console.log(props);
  const temp_result = props.searchres;
  return (
    <div class = "searchresultpage">
            <div>
                <h1 style = {{fontWeight:'bold', fontSize:40, textAlign:'center'}}> Search Result </h1>
            </div>

            <div className="imgDetail">
              <img src={temp_result.book_image} alt={temp_result.title}  height = "300px" width="200px"></img>
            </div>

      <div className= "contentDetail" >{temp_result.title}</div>
    </div>
  );
};



export default Details;
