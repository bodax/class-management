import React, {Component} from 'react';
import StudentsService from '../services/StudentsService';


class StudentDetails extends Component {
    constructor(props) {
        super(props);
        this.state = {
            id: this.props.match.params.id,
            student: {}
        }
    }

    componentDidMount() {
        StudentsService.getStudentById(this.state.id).then(res => this.setState({student: res.data}));
    }

    sendHome = () => {
        this.props.history.push("/")
    }

    render() {

        return (
            <div>
                <h3>Students Details</h3>
                <div className="container">
                    <div className="row">
                        <div className="card col-md-6 offset-md-3">
                            <h3 className="text-center">{`${this.state.student.firstName} ${this.state.student.lastName}`}</h3>
                            <div className="card-body">
                                <div>
                                    <div style={{display: "flex", justifyContent: "flex-start"}}>
                                        <label style={{marginRight: "15px", fontWeight: "bold"}}>Course :</label>
                                        <p>{this.state.student.course}</p>
                                    </div>
                                    <div style={{display: "flex", justifyContent: "flex-start"}}>
                                        <label style={{marginRight: "15px", fontWeight: "bold"}}>Contact email :</label>
                                        <p>{this.state.student.emailId}</p>
                                    </div>
                                    <div style={{display: "flex", justifyContent: "flex-start"}}>
                                        <label style={{marginRight: "15px", fontWeight: "bold"}}>City :</label>
                                        <p>{this.state.student.city}</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div className="row">
                    <div className="col text-center">
                        <button type="button" className="btn btn-secondary btn-lg" style={{marginTop: "45px"}}
                                onClick={this.sendHome}>Back to Homepage
                        </button>
                    </div>
                </div>
            </div>
        );
    }
}


export default StudentDetails;