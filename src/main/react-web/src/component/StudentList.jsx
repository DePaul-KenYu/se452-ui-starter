import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faUserEdit, faUserTimes, faUserPlus } from '@fortawesome/free-solid-svg-icons'

function StudentList() {
  const [students, setStudents] = useState([]);
  useEffect(() => {
    const fetchData = async () => {
      const response = await axios.get("/api/students/");
      setStudents(response.data);
    };
    fetchData();
  }, []);

  return (
    <section className="section">
      <table className="table">
        <thead>
          <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Edit</th>
            <th>Delete</th>
          </tr>
        </thead>
        <tbody>
          {students.map((student) => (
            <tr key={student.id}>
              <td>{student.name}</td>
              <td>{student.email}</td>
              <td>
                <Link to={`/students/edit/${student.id}`}>
                  <i><FontAwesomeIcon icon={faUserEdit}/></i>
                </Link>
              </td>
              <td>
                <Link to={`/students/delete/${student.id}`}>
                  <i><FontAwesomeIcon icon={faUserTimes}/></i>
                  </Link>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
      <p className="my-5">
        <a href="add" className="btn btn-primary">
          <i><FontAwesomeIcon icon={faUserPlus}/></i>
        </a>
      </p>
    </section>
  );
}

export default StudentList;
