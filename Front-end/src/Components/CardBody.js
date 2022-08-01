import { Col, Table } from "react-bootstrap";

export default function CardBody(props) {
    return (
        <Col>
            <Table>
                <tbody>
                    <tr>
                        <td className="text-left">
                            {props.text}
                        </td>
                        <td className="text-right">
                            {props.value}
                        </td>
                    </tr>
                </tbody>
            </Table>
        </Col>
    );

}