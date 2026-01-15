
import "../App.css"
import Axios from "axios";
import * as React from 'react';
import PropTypes from 'prop-types';
import { useTheme } from '@mui/material/styles';
import Box from '@mui/material/Box';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableFooter from '@mui/material/TableFooter';
import TablePagination from '@mui/material/TablePagination';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import IconButton from '@mui/material/IconButton';
import FirstPageIcon from '@mui/icons-material/FirstPage';
import KeyboardArrowLeft from '@mui/icons-material/KeyboardArrowLeft';
import KeyboardArrowRight from '@mui/icons-material/KeyboardArrowRight';
import LastPageIcon from '@mui/icons-material/LastPage';
import TextField from '@mui/material/TextField';
import {Button} from "@mui/material";
import {useEffect} from "react";



function TablePaginationActions(props) {
    const theme = useTheme();
    const { count, page, rowsPerPage, onPageChange } = props;

    const handleFirstPageButtonClick = (event) => {
        onPageChange(event, 0);
    };

    const handleBackButtonClick = (event) => {
        onPageChange(event, page - 1);
    };

    const handleNextButtonClick = (event) => {
        onPageChange(event, page + 1);
    };

    const handleLastPageButtonClick = (event) => {
        onPageChange(event, Math.max(0, Math.ceil(count / rowsPerPage) - 1));
    };

    return (
        <Box sx={{ flexShrink: 0, ml: 2.5 }}>
            <IconButton
                onClick={handleFirstPageButtonClick}
                disabled={page === 0}
                aria-label="first page"
            >
                {theme.direction === 'rtl' ? <LastPageIcon /> : <FirstPageIcon />}
            </IconButton>
            <IconButton
                onClick={handleBackButtonClick}
                disabled={page === 0}
                aria-label="previous page"
            >
                {theme.direction === 'rtl' ? <KeyboardArrowRight /> : <KeyboardArrowLeft />}
            </IconButton>
            <IconButton
                onClick={handleNextButtonClick}
                disabled={page >= Math.ceil(count / rowsPerPage) - 1}
                aria-label="next page"
            >
                {theme.direction === 'rtl' ? <KeyboardArrowLeft /> : <KeyboardArrowRight />}
            </IconButton>
            <IconButton
                onClick={handleLastPageButtonClick}
                disabled={page >= Math.ceil(count / rowsPerPage) - 1}
                aria-label="last page"
            >
                {theme.direction === 'rtl' ? <FirstPageIcon /> : <LastPageIcon />}
            </IconButton>
        </Box>
    );
}

TablePaginationActions.propTypes = {
    count: PropTypes.number.isRequired,
    onPageChange: PropTypes.func.isRequired,
    page: PropTypes.number.isRequired,
    rowsPerPage: PropTypes.number.isRequired,
};

function createRow(id, problem, pattern, note, visualization, difficulty) {
    return { id, problem, pattern, note, visualization, difficulty };
}


export default function CustomPaginationActionsTable() {
    const [page, setPage] = React.useState(0);
    const [rowsPerPage, setRowsPerPage] = React.useState(5);

    const handleChangePage = (event, newPage) => {
        setPage(newPage);
    };

    const handleChangeRowsPerPage = (event) => {
        setRowsPerPage(parseInt(event.target.value, 10));
        setPage(0);
    };

    useEffect(() => {
        fetch("https://leetnote-backend-separate.onrender.com/problems")
        // fetch("http://localhost:3002/problems")
            .then(res => res.json())
            .then(data => {
                const mapped = data.map(row =>
                    createRow(
                        row.id,
                        row.Problem,
                        row.Pattern,
                        row.Note ?? "",
                        row.Visualization,   // "/videos/xxx.mp4"
                        row.Difficulty?.toLowerCase()
                    )
                );
                setRows(mapped);
            })
            .catch(err => console.error(err));
    }, []);


    const [rows, setRows] = React.useState([]);

    const handleNoteChange = (index, value) => {
        const updated = [...rows];
        updated[index].note = value; // note your property is 'notes', not 'note'
        setRows(updated);
    };


    // Avoid a layout jump when reaching the last page with empty rows.
    const emptyRows =
        page > 0 ? Math.max(0, (1 + page) * rowsPerPage - rows.length) : 0;


    return (
        <TableContainer component={Paper}>
            <Table sx={{ minWidth: 500 ,  bgcolor: '#020617',
                color: '#e5e7eb',
                '& td, & th': {
                    color: '#e5e7eb',
                    borderColor: '#1e293b',
                }, }} aria-label="custom pagination table">
                <TableBody>
                    {(rowsPerPage > 0
                            ? rows.slice(page * rowsPerPage, page * rowsPerPage + rowsPerPage)
                            : rows
                    ).map((row, index) => (
                        <TableRow key={row.id} >
                            {/* Problem */}
                            <TableCell
                                sx={{
                                    width: "20%",
                                    overflowY: "auto",
                                    fontWeight: "bold",
                                    px: 1,
                                    py: 0.5,
                                }}
                            >


                                {(() => {
                                    let difficultyColor = "error";
                                    if (row.difficulty === "easy") difficultyColor = "success";
                                    else if (row.difficulty === "medium") difficultyColor = "secondary";

                                    return (
                                        <Button variant="outlined" sx={{padding: 1}}  size="small" color={difficultyColor}>
                                            {row.difficulty}
                                        </Button>
                                    );
                                })()}

                                {/*<div> {row.problem} </div>*/}





                                <div
                                    style={{
                                        maxHeight: 320,    // max row height for problem cell
                                        overflowY: "auto",   // scroll if content is too long
                                        whiteSpace: "pre-wrap",
                                        wordWrap: "break-word",
                                        alignSelf: "flex-start",
                                        display: "block",
                                        padding: "1px",
                                        fontSize: "large"

                                    }}
                                >

                                    {row.problem}
                                </div>
                            </TableCell>





                            {/* Pattern & Notes */}
                            <TableCell sx={{ width: '35%', verticalAlign: 'top' }}>
                                <Button variant="contained" sx={{padding: 1}}  size="small" color="success">
                                    <strong>{row.pattern}</strong>
                                </Button>

                                <TextField
                                    multiline
                                    minRows={3}
                                    maxRows={15}
                                    value={row.note}
                                    onChange={(e) =>
                                        handleNoteChange(page * rowsPerPage + index, e.target.value)
                                    }
                                    placeholder="Write notes here…"
                                    variant="outlined"
                                    fullWidth

                                    sx={{
                                        mt: 1,
                                        '& .MuiInputBase-root': {
                                            bgcolor: '#020617',
                                            color: '#e5e7eb',
                                        },
                                        '& .MuiOutlinedInput-notchedOutline': {
                                            borderColor: '#1e293b',
                                        },
                                        '&:hover .MuiOutlinedInput-notchedOutline': {
                                            borderColor: '#38bdf8',
                                        },
                                        '& .MuiInputBase-input::placeholder': {
                                            color: '#64748b',
                                        },
                                    }}
                                />
                            </TableCell>


                            {/* Video */}
                            <TableCell sx={{ width: "55%" }}>
                                <video
                                    key={row.visualization}
                                    controls
                                    preload="metadata"
                                    muted
                                    style={{ width: '100%', borderRadius: 8 }}
                                >

                                <source
                                    // src={`http://localhost:3002/videos/${row.visualization}`}
                                    src={`https://leetnote-backend-separate.onrender.com/videos/${row.visualization}`}
                                    type="video/mp4" />
                                    Your browser does not support the video tag.
                                </video>
                            </TableCell>
                        </TableRow>
                    ))}
                </TableBody>

                <TableFooter>
                    <TableRow>
                        <TablePagination
                            rowsPerPageOptions={[5, 10, 25, { label: 'All', value: -1 }]}
                            colSpan={3}
                            count={rows.length}
                            rowsPerPage={rowsPerPage}
                            page={page}
                            sx={{
                                color: '#e5e7eb',

                                '& .MuiSvgIcon-root': {
                                    color: '#e5e7eb',
                                },

                                '& .MuiIconButton-root': {
                                    color: '#e5e7eb',
                                    transition: 'background-color 0.2s ease',

                                    '&:hover': {
                                        bgcolor: '#1e293b',
                                    },
                                },

                                '& .MuiIconButton-root.Mui-disabled': {
                                    color: '#475569',
                                },

                                '& .MuiSelect-icon': {
                                    color: '#e5e7eb',
                                },
                            }}
                            SelectProps={{
                                MenuProps: {
                                    PaperProps: {
                                        sx: {
                                            bgcolor: '#020617',
                                            color: '#e5e7eb',
                                            '& .MuiMenuItem-root:hover': { bgcolor: '#1e293b' },
                                            '& .MuiMenuItem-root.Mui-selected': { bgcolor: '#334155' },
                                        },
                                    },
                                },
                            }}
                            onPageChange={handleChangePage}
                            onRowsPerPageChange={handleChangeRowsPerPage}
                            ActionsComponent={TablePaginationActions}
                        />
                    </TableRow>
                </TableFooter>
            </Table>
        </TableContainer>
    );
}
