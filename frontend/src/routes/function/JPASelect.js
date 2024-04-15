import {Accordion, CloseButton, Table} from "react-bootstrap";
import {useNavigate} from "react-router-dom";

const JPASelect = () => {

    const navigate = useNavigate();

    return (
        <div className="container">
            <div className="titleAndClose">
                <h3 className="titleStyle">JPA Select</h3>
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

            <Table responsive="sm">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Table heading</th>
                    <th>Table heading</th>
                    <th>Table heading</th>
                    <th>Table heading</th>
                    <th>Table heading</th>
                    <th>Table heading</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>1</td>
                    <td>Table cell</td>
                    <td>Table cell</td>
                    <td>Table cell</td>
                    <td>Table cell</td>
                    <td>Table cell</td>
                    <td>Table cell</td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>Table cell</td>
                    <td>Table cell</td>
                    <td>Table cell</td>
                    <td>Table cell</td>
                    <td>Table cell</td>
                    <td>Table cell</td>
                </tr>
                </tbody>
            </Table>
        </div>
    )

}

export default JPASelect;