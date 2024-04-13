import {Accordion, Button, CloseButton, Col, FloatingLabel, Form, Row} from "react-bootstrap";
import {useNavigate} from "react-router-dom";
import {useEffect, useState} from "react";
import axios from "axios";
import SaveSuccess from "../message/SaveSuccess";

const Reservation = () => {

    const selectRoomTypeURL = "/api/roomType";
    const selectAvailableRoomNoURL = "/api/availableRoomNo";
    const saveReservationURL = "/api/saveReservation";

    const navigate = useNavigate();
    const [reservationName, setReservationName] = useState("");
    const [arrivalDate, setArrivalDate] = useState("");
    const [departureDate, setDepartureDate] = useState("");
    const [birthDate, setBirthDate] = useState("");
    const [nights, setNights] = useState(1);
    const [roomTypeOptions, setRoomTypeOptions] = useState([]);
    const [roomType, setRoomType] = useState("");
    const [roomNoOptions, setRoomNoOptions] = useState([]);
    const [roomNo, setRoomNo] = useState("");
    const [roomRate, setRoomRate] = useState("");
    const [mobileNo, setMobileNo] = useState("");
    const [email, setEmail] = useState("");
    const [address, setAddress] = useState("");
    const [detailAddress, setDetailAddress] = useState("");
    const [display, setDisplay] = useState(false);

    useEffect(() => {
        setNights(1);
    }, []);

    useEffect(() => {
        axios.get(selectRoomTypeURL)
            .then(res => {
                setRoomTypeOptions(res.data);
            })
    }, []);

    const changeText = (e) => {
        if(e.target.name === "reservationName") setReservationName(e.target.value);
        if(e.target.name === "email") setEmail(e.target.value);
        if(e.target.name === "address") setAddress(e.target.value);
        if(e.target.name === "detailAddress") setDetailAddress(e.target.value);
    }

    const changeNights = (e) => {
        setNights(e.target.value);
    }

    const formatDate = (e) => {
        const inputDate = e.target.value;
        const regex = /^\d{4}-\d{2}-\d{2}$/;

        if(regex.test(inputDate)){
            if(e.target.name === "arrivalDate") setArrivalDate(e.target.value);
            if(e.target.name === "departureDate") setDepartureDate(e.target.value);
            if(e.target.name === "birthDate") setBirthDate(e.target.value);
        }
    }

    const formatMobileNo = (e) => {
        const mobileNo = e.target.value.replace(/\D/g, '');
        const formattedMobileNo = mobileNo.replace(/^(\d{3})(\d{0,4})?(\d{0,4})?/, '$1-$2-$3');

        setMobileNo(formattedMobileNo);
    }

    const selectAvailableRoomNo = (e) => {
        const selectedIndex = e.target.selectedIndex;
        const standardRoomRate = e.target.options[selectedIndex].getAttribute("data-value");

        setRoomType(e.target.value);
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

    const changeRoomRate = (e) => {
        setRoomRate(e.target.value);
    }

    const changeRoomNo = (e) => {
        setRoomNo(e.target.value);
    }

    const saveReservation = (e) => {
        e.preventDefault();

        const formData = {
            reservationName,
            arrivalDate: arrivalDate.replaceAll("-", ""),
            departureDate: departureDate.replaceAll("-", ""),
            nights,
            roomType,
            roomNo,
            roomRate,
            birthDate: birthDate.replaceAll("-", ""),
            mobileNo: mobileNo.replaceAll("-", ""),
            email,
            address,
            detailAddress
        }

        axios.post(saveReservationURL, formData)
            .then((res) => {
                console.log(res);
                setDisplay(true);
            })
    }

    const closeMessageBox = () => {
        setDisplay(false);
        navigate("/");
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
                        JPA, QueryDSL을 이용한 예약 생성 화면입니다.
                    </Accordion.Body>
                </Accordion.Item>
            </Accordion>

            <Form onSubmit={(e) => saveReservation(e)}>
                <h5 className="titleAndClose">예약 정보</h5>
                <div className="divider"/>

                <Row className="mb-3">
                    <Form.Group className="formLabel" as={Col}>
                        <FloatingLabel controlId="floatingInput" label="예약자명" className="mb-3">
                            <Form.Control type="text" placeholder="name@example.com" name="reservationName" value={reservationName} onChange={(e) => changeText(e)}/>
                        </FloatingLabel>
                    </Form.Group>
                    <Form.Group className="formLabel" as={Col}>
                        <FloatingLabel controlId="floatingInput" label="입실 일자" className="mb-3">
                            <Form.Control type="date" placeholder="yyyy-mm-dd" name="arrivalDate" onChange={(e) => formatDate(e)} value={arrivalDate}/>
                        </FloatingLabel>
                    </Form.Group>
                    <Form.Group className="formLabel" as={Col}>
                        <FloatingLabel controlId="floatingInput" label="퇴실 일자" className="mb-3">
                            <Form.Control type="date" placeholder="yyyy-mm-dd" name="departureDate" onChange={(e) => formatDate(e)} value={departureDate}/>
                        </FloatingLabel>
                    </Form.Group>
                    <Form.Group className="formLabel" as={Col}>
                        <FloatingLabel controlId="floatingInput" label="박수" className="mb-3">
                            <Form.Control type="text" placeholder="name@example.com" name="nights" value={nights} onChange={(e) => changeNights(e)}/>
                        </FloatingLabel>
                    </Form.Group>
                </Row>

                <Row className="mb-3">
                    <Form.Group className="formLabel" as={Col}>
                        <FloatingLabel controlId="floatingInput" label="객실 타입" className="mb-3">
                            <Form.Select defaultValue="" name="roomType" value={roomType} onChange={(e) => selectAvailableRoomNo(e)}>
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
                            <Form.Select defaultValue="" name="roomNo" value={roomNo} onChange={(e) => changeRoomNo(e)}>
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
                            <Form.Control type="text" placeholder="name@example.com" name="roomRate" value={roomRate} onChange={(e) => changeRoomRate(e)}/>
                        </FloatingLabel>
                    </Form.Group>
                </Row>

                <h5 className="titleAndClose">개인 정보</h5>
                <div className="divider"/>

                <Row className="mb-3">
                    <Form.Group className="formLabel" as={Col}>
                        <FloatingLabel controlId="floatingInput" label="생년월일" className="mb-3">
                            <Form.Control type="date" placeholder="yyyy-mm-dd" name="birthDate" onChange={(e) => formatDate(e)} value={birthDate}/>
                        </FloatingLabel>
                    </Form.Group>
                    <Form.Group className="formLabel" as={Col}>
                        <FloatingLabel controlId="floatingInput" label="Mobile No" className="mb-3">
                            <Form.Control type="text" placeholder="name@example.com" name="mobileNo" onChange={(e) => {formatMobileNo(e)}} value={mobileNo}/>
                        </FloatingLabel>
                    </Form.Group>
                    <Form.Group className="formLabel" as={Col}>
                        <FloatingLabel controlId="floatingInput" label="E-Mail" className="mb-3">
                            <Form.Control type="text" placeholder="name@example.com" name="email" value={email} onChange={(e) => changeText(e)}/>
                        </FloatingLabel>
                    </Form.Group>
                </Row>
                <Row className="mb-3">
                    <Form.Group className="formLabel" as={Col}>
                        <FloatingLabel controlId="floatingInput" label="주소" className="mb-3">
                            <Form.Control type="text" placeholder="name@example.com" name="address" value={address} onChange={(e) => changeText(e)}/>
                        </FloatingLabel>
                    </Form.Group>
                    <Form.Group className="formLabel" as={Col}>
                        <FloatingLabel controlId="floatingInput" label="상세 주소" className="mb-3">
                            <Form.Control type="text" placeholder="name@example.com" name="detailAddress" value={detailAddress} onChange={(e) => changeText(e)}/>
                        </FloatingLabel>
                    </Form.Group>
                </Row>

                <Button variant="primary" type="submit" style={{float: "right"}}>
                    Save
                </Button>
            </Form>

            <SaveSuccess display={display} closeMessageBox={closeMessageBox}/>
        </div>
    )

}

export default Reservation;