import {Button, Modal} from "react-bootstrap";

const SaveSuccess = ({display, closeMessageBox}) => {

    return (
        <div>
            <Modal show={display} onHide={() => closeMessageBox()}>
                <Modal.Header>
                    <Modal.Title>저장되었습니다.</Modal.Title>
                </Modal.Header>

                <Modal.Footer>
                    <Button variant="secondary" onClick={() => closeMessageBox()}>Close</Button>
                </Modal.Footer>
            </Modal>

        </div>
    )

}

export default SaveSuccess;