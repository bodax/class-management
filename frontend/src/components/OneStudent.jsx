import React, {Component} from 'react';

class OneStudent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            country: this.props.student.country
        }

    }

    studentDetails = (id) => {
        this.props.history.push(`/student-details/${id}`)
    }

    render() {
        return (
            <td>
                <div>{this.props.student.country}</div>
            </td>

        );
    }
}

export default OneStudent;