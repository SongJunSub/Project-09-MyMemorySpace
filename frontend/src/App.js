import './App.css';
import React from "react";
import TopContainer from "./routes/TopContainer";
import {Route, Routes} from "react-router-dom";
import JPASelect from "./routes/JPASelect";

function App(){

    return (
        <div className="App">
            <TopContainer/>

            <Routes>
                <Route path="/api/jpaSelect" element={
                    <JPASelect/>
                }/>
            </Routes>
        </div>
    );

}

export default App;
