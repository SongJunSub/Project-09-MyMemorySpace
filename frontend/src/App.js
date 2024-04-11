import './App.css';
import React from "react";
import TopContainer from "./routes/container/TopContainer";
import {Route, Routes} from "react-router-dom";
import JPASelect from "./routes/function/JPASelect";
import BottomContainer from "./routes/container/BottomContainer";
import Main from "./routes/Main";
import Reservation from "./routes/function/Reservation";

function App(){

    return (
        <div className="App">
            <TopContainer/>

            <Routes>
                <Route path="/" element={
                    <Main/>
                }/>
                <Route path="/api/reservation" element={
                    <Reservation/>
                }/>
                <Route path="/api/jpaSelect" element={
                    <JPASelect/>
                }/>
            </Routes>

            <BottomContainer/>
        </div>
    );

}

export default App;
