import {Accordion, Button, CloseButton, Col, FloatingLabel, Form, Row} from "react-bootstrap";
import {useNavigate} from "react-router-dom";
import 'react-datepicker/dist/react-datepicker.css';
import {useEffect, useState} from "react";
import axios from "axios";

const Reservation = () => {

    const selectRoomTypeURL = "/api/roomType";
    const selectAvailableRoomNoURL = "/api/availableRoomNo";

    const navigate = useNavigate();
    const [date, setDate] = useState("");
    const [nights, setNights] = useState(1);
    const [roomTypeOptions, setRoomTypeOptions] = useState([]);
    const [roomTypeValue, setRoomTypeValue] = useState("");
    const [roomNoOptions, setRoomNoOptions] = useState([]);
    const [roomRate, setRoomRate] = useState("");
    const [mobileNo, setMobileNo] = useState("");

    useEffect(() => {
        setNights(1);
    }, []);

    useEffect(() => {
        axios.get(selectRoomTypeURL)
            .then(res => {
                setRoomTypeOptions(res.data);
            })
    }, []);

    const formatDate = (e) => {
        const inputDate = e.target.value;
        const regex = /^\d{4}-\d{2}-\d{2}$/;

        if(regex.test(inputDate)) setDate(inputDate);
    }

    const formatMobileNo = (e) => {
        const mobileNo = e.target.value.replace(/\D/g, '');
        const formattedMobileNo = mobileNo.replace(/^(\d{3})(\d{0,4})?(\d{0,4})?/, '$1-$2-$3');

        setMobileNo(formattedMobileNo);
    }

    const selectAvailableRoomNo = (e) => {
        const selectedIndex = e.target.selectedIndex;
        const standardRoomRate = e.target.options[selectedIndex].getAttribute("data-value");

        setRoomTypeValue(e.target.value);
        setRoomRate(standardRoomRate);

        axios.get(selectAvailableRoomNoURL, {
            params: {
                roomTypeCode : e.target.value
            }
        })
            .then(res => {
                setRoomNoOptions(res.data);
            })
    }

    return (
        <div className="container">
            <div className="titleAndClose">
                <h3 className="titleStyle">Reservation</h3>
                <CloseButton className="closeName" onClick={() => {navigate("/")}}/>
            </div>

            <Accordion className="introduceAccordion" defaultActiveKey="0">
                <Accordion.Item eventKey="0">
                    <Accordion.Header>Introduction #1</Accordion.Header>
                    <Accordion.Body className="accordionBody">
                        JPA, QueryDSL을 이용한 조회 화면입니다.
                    </Accordion.Body>
                </Accordion.Item>
            </Accordion>

            <Form>
                <h5 className="titleAndClose">예약 정보</h5>
                <div className="divider"/>

                <Row className="mb-3">
                    <Form.Group className="formLabel" as={Col}>
                        <FloatingLabel controlId="floatingInput" label="예약자명" className="mb-3">
                            <Form.Control type="text" placeholder="name@example.com"/>
                        </FloatingLabel>
                    </Form.Group>
                    <Form.Group className="formLabel" as={Col}>
                        <FloatingLabel controlId="floatingInput" label="입실 일자" className="mb-3">
                            <Form.Control type="date" placeholder="yyyy-mm-dd" onChange={(e) => formatDate(e)} value={date}/>
                        </FloatingLabel>
                    </Form.Group>
                    <Form.Group className="formLabel" as={Col}>
                        <FloatingLabel controlId="floatingInput" label="퇴실 일자" className="mb-3">
                            <Form.Control type="date" placeholder="yyyy-mm-dd" onChange={(e) => formatDate(e)} value={date}/>
                        </FloatingLabel>
                    </Form.Group>
                    <Form.Group className="formLabel" as={Col}>
                        <FloatingLabel controlId="floatingInput" label="박수" className="mb-3">
                            <Form.Control type="text" placeholder="name@example.com" value={nights}/>
                        </FloatingLabel>
                    </Form.Group>
                </Row>

                <Row className="mb-3">
                    <Form.Group className="formLabel" as={Col}>
                        <FloatingLabel controlId="floatingInput" label="객실 타입" className="mb-3">
                            <Form.Select value={roomTypeValue} onChange={(e) => selectAvailableRoomNo(e)}>
                                <option value="">Choose...</option>
                                {
                                    roomTypeOptions.map(option => (
                                        <option value={option.roomTypeCode} data-value={option.standardRoomRate}>
                                            {option.roomTypeName}
                                        </option>
                                    ))
                                }
                            </Form.Select>
                        </FloatingLabel>
                    </Form.Group>
                    <Form.Group className="formLabel" as={Col}>
                        <FloatingLabel controlId="floatingInput" label="Room No" className="mb-3">
                            <Form.Select defaultValue="">
                                <option value="">Choose...</option>
                                {
                                    roomNoOptions.map(option => (
                                        <option value={option.roomNo}>
                                            {option.roomNo}
                                        </option>
                                    ))
                                }
                            </Form.Select>
                        </FloatingLabel>
                    </Form.Group>
                    <Form.Group className="formLabel" as={Col}>
                        <FloatingLabel controlId="floatingInput" label="객실료" className="mb-3">
                            <Form.Control type="text" placeholder="name@example.com" value={roomRate}/>
                        </FloatingLabel>
                    </Form.Group>
                </Row>

                <h5 className="titleAndClose">개인 정보</h5>
                <div className="divider"/>

                <Row className="mb-3">
                    <Form.Group className="formLabel" as={Col}>
                        <FloatingLabel controlId="floatingInput" label="생년월일" className="mb-3">
                            <Form.Control type="date" placeholder="yyyy-mm-dd" onChange={(e) => formatDate(e)} value={date}/>
                        </FloatingLabel>
                    </Form.Group>
                    <Form.Group className="formLabel" as={Col}>
                        <FloatingLabel controlId="floatingInput" label="Mobile No" className="mb-3">
                            <Form.Control type="text" placeholder="name@example.com" onChange={(e) => {formatMobileNo(e)}} value={mobileNo}/>
                        </FloatingLabel>
                    </Form.Group>
                    <Form.Group className="formLabel" as={Col}>
                        <FloatingLabel controlId="floatingInput" label="E-Mail" className="mb-3">
                            <Form.Control type="text" placeholder="name@example.com"/>
                        </FloatingLabel>
                    </Form.Group>
                </Row>
                <Row className="mb-3">
                    <Form.Group className="formLabel" as={Col}>
                        <FloatingLabel controlId="floatingInput" label="주소" className="mb-3">
                            <Form.Control type="text" placeholder="name@example.com"/>
                        </FloatingLabel>
                    </Form.Group>
                    <Form.Group className="formLabel" as={Col}>
                        <FloatingLabel controlId="floatingInput" label="상세 주소" className="mb-3">
                            <Form.Control type="text" placeholder="name@example.com"/>
                        </FloatingLabel>
                    </Form.Group>
                </Row>

                <Button variant="primary" type="submit" style={{float: "right"}}>
                    Save
                </Button>
            </Form>
        </div>
    )

}

export default Reservation;